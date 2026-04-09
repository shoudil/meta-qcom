PLATFORM = "lemans"
PBT_BUILD_DATE = "260403"

require common.inc

SRC_URI[camxlib.sha256sum]     = "c3a2899a19078c0ced7ae6ec4605b84834eae33893820f05a34e864f198bdfc9"
SRC_URI[camx.sha256sum]        = "91bfc42dad35adef895656dfef48f4eacb4059e49b813dec9cbece9a4b30a309"
SRC_URI[chicdk.sha256sum]      = "4c83df2a4690759979087d112633d43420599ab4906f233109591528107d4769"
SRC_URI[camxcommon.sha256sum]  = "89ee02d0b4bd09dcca091be2f2339ff50b6a34fc50ca51c612b0e633768a956d"

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
