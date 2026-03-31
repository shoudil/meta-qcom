PLATFORM = "lemans"
PBT_BUILD_DATE = "260324"

require common.inc

SRC_URI[camxlib.sha256sum]     = "568d7dde1bcd6391391c42aa62db9abb8ad645a36dcb7053fd94a91c82a08596"
SRC_URI[camx.sha256sum]        = "45802dbf8f69b1731ac74588264566f1165ab554b7a9dafd7ec4d142cc409ee3"
SRC_URI[chicdk.sha256sum]      = "714fe40e3e20dfee2642f91f0d9ff4e25d9c3fd4d7351451952cfc2dc5628b9a"
SRC_URI[camxcommon.sha256sum]  = "5d4436269aa4f426251b9054aeae0f4f0e784c278a5420d067a23d81b50a5c3c"

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
