PLATFORM = "lemans"
PBT_BUILD_DATE = "260411"

require common.inc

SRC_URI[camxlib.sha256sum]     = "3ddbe79a9753b3238f3fb6072022a9a572be946576e1c9c43c383795a1f9cb4e"
SRC_URI[camx.sha256sum]        = "5733fecdfb12339c9a4063e0058badf1c69a79327afb0be754a33832c577b149"
SRC_URI[chicdk.sha256sum]      = "d26a55a95c11dcd8d350f6161465ee81845b5f0cdb9231997092c85fc95a60e5"
SRC_URI[camxcommon.sha256sum]  = "e035bb3a34231dd12f3d2c73f87c10d116c1ec8bc6b289efd20924d9a6fbd00e"

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
