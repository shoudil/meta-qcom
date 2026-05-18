PLATFORM = "lemans"
PBT_BUILD_DATE = "260515"

require common.inc

SRC_URI[camxlib.sha256sum] = "15a96f7e3074a937f218d409ad068dba693eebc9ce518bf867399e6faf454e34"
SRC_URI[camx.sha256sum] = "2c8d668138e2c81fee8179e3f71fc35c244f5b353bb83386bc3e5f3523263b9e"
SRC_URI[chicdk.sha256sum] = "2770e377c159f25fb1bd656754987920f9439efb2233ad49135077808e073e4f"
SRC_URI[camxcommon.sha256sum] = "ec9910a6b243af5518e748cb93b525bed9072a124d2cb87abfc1f61566a34b28"

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
