SUMMARY = "CBSP boot utilities - UEFI capsule generation scripts (native)"
DESCRIPTION = "Build-host toolchain for UEFI FMP capsule generation on Qualcomm platforms."
HOMEPAGE = "https://github.com/quic/cbsp-boot-utilities"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://uefi_capsule_generation/LICENSE;md5=8e1eb38e3de3966193d29f31f5d7e684"

SRC_URI = "git://github.com/quic/cbsp-boot-utilities.git;protocol=https;branch=main \
           file://0001-FVCreation-fall-back-to-PATH-when-locating-GenFfs-Ge.patch \
          "
SRCREV = "c25b41a49595aca2a3480db050dee78edd2a3bff"

inherit native
inherit python3native

DEPENDS = " \
    dtc-native \
    edk2-basetools-native \
    python3-dtc-native \
    python3-pyelftools-native \
"

do_configure[noexec] = "1"
do_compile[noexec]   = "1"

do_install() {
    install -d "${D}${datadir}/cbsp-boot-utilities"
    install -m 0644 "${S}/uefi_capsule_generation/"*.py  "${D}${datadir}/cbsp-boot-utilities/"
    install -m 0644 "${S}/uefi_capsule_generation/"*.xml "${D}${datadir}/cbsp-boot-utilities/"
}
