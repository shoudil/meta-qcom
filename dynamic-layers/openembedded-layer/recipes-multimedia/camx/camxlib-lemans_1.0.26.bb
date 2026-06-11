PLATFORM = "lemans"
PBT_BUILD_DATE = "260608"

require common.inc

SRC_URI[camxlib.sha256sum] = "1a8b1e8d2ad8d1697b566130bde4f83df500d6ff0479613fdcda70e129d85686"
SRC_URI[camx.sha256sum] = "b5b7e51f30bfd6cdbd56dcda9ceeee50cb1f0519c65e98c3a0fe74a1e77b2cec"
SRC_URI[chicdk.sha256sum] = "765bdbac41ad3b223bd74e289f16b0fa2c12b2fe7a58e0dcf81dc7c653538857"
SRC_URI[camxcommon.sha256sum] = "4897fd152b8858cf93d0b31ba2d8e46842cdcd917a3ed10493bc1fec84de3276"



DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'opencl', 'qcom-adreno virtual/libopencl1', '', d)}"

do_install:append() {
    # Copy json only when /etc folder exists in ${S}
    if [ -d "${S}/etc" ]; then
        install -d ${D}${sysconfdir}/camera/test/NHX/
        cp -r ${S}/etc/camera/test/NHX/*.json ${D}${sysconfdir}/camera/test/NHX/
    fi
}

RPROVIDES:${PN} = "camxlib-monaco"
PACKAGE_BEFORE_PN += "camx-nhx"
RRECOMMENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'opencl', 'virtual-opencl-icd', '', d)}"

FILES:camx-nhx = "\
    ${bindir}/nhx.sh \
    ${sysconfdir}/camera/test/NHX/ \
"

FILES:${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'opencl', '${libdir}/camx/${PLATFORM}/*.cl ${libdir}/camx/${PLATFORM}/libmctf_cl_program.bin', '', d)}"
