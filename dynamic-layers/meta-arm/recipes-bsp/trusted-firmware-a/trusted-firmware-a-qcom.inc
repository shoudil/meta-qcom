DEPENDS += "qtestsign-native optee-os-qcom"

SRC_URI += "git://github.com/coreboot/qc_blobs.git;protocol=https;name=qc_blobs;subdir=qc_blobs;branch=main"
SRCREV_qc_blobs = "16207f367ddbf280a0c2c8a3d3ee454a59710a25"

LICENSE += "& LICENSE.qcom"
LIC_FILES_CHKSUM:qcm6490 += "file://${UNPACKDIR}/qc_blobs/sc7280/qtiseclib/LICENSE;md5=fa83f30385e617b56ef0934f13645621"

COMPATIBLE_MACHINE:qcm6490 = "qcm6490"
TFA_PLATFORM:qcm6490 = "rb3gen2"

TFA_UBOOT ?= "1"
TFA_BUILD_TARGET = "bl2 fip"
TFA_SPD = "opteed"

EXTRA_OEMAKE:append = " \
    BL32=${RECIPE_SYSROOT}/${nonarch_base_libdir}/firmware/tee-raw.bin \
   "

EXTRA_OEMAKE:append:qcm6490 = " \
    QTISECLIB_PATH=${UNPACKDIR}/qc_blobs/sc7280/qtiseclib/libqtisec.a \
   "

do_install:append:qcm6490() {
    export CRYPTOGRAPHY_OPENSSL_NO_LEGACY=1

    ${OBJCOPY} -I binary -B aarch64 -O elf64-littleaarch64 ${D}${FIRMWARE_DIR}/fip.bin ${D}${FIRMWARE_DIR}/fip.o
    ${LD} ${D}${FIRMWARE_DIR}/fip.o -o ${D}${FIRMWARE_DIR}/fip_unsigned.elf -EL -T ${S}/tools/qti/fip-elf.lds --defsym=ELFENTRY=0x9fc00000 -Ttext=0x9fc00000
    rm -f ${D}${FIRMWARE_DIR}/fip.o

    qtestsign -v6 aboot -o ${D}${FIRMWARE_DIR}/fip.elf ${D}${FIRMWARE_DIR}/fip_unsigned.elf
    rm -f ${D}${FIRMWARE_DIR}/fip_unsigned.elf
}
