PLATFORM = "lemans"
PBT_BUILD_DATE = "260416"

require common.inc

SRC_URI[camxlib.sha256sum]     = "13039dd2d9d31bc9e21d55bb8165920aa367da90a0604c95f0459c8902a33da8"
SRC_URI[camx.sha256sum]        = "70e9a815f7a1e83bb5d9ee0ff18c1b79a0ccc6b0ec9758c4f39d82c6c259e698"
SRC_URI[chicdk.sha256sum]      = "5922944716bc3949a93984e29ec00b1d2076efec0c8da7cecb3713ff52879a92"
SRC_URI[camxcommon.sha256sum]  = "7ee0f8cd78e42237058d3a3d7df8a70c0be7bd2316642f17e3bcf4b6e6637934"

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
