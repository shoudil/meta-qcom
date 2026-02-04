SUMMARY = "CamX camera module with core interface utilities, extended image processing libraries, and CHI developer kit including sensor, tuning binaries"
DESCRIPTION = "This recipe introduces Qualcomm CamX camera module which creates three components.\
   camxlib: Includes common utilities, image processing algorithms and hardware support libraries extending CamX functionality for platform-specific enhancements. \
   camx: Core CamX engine that manages camera pipelines, mediates between camera clients and hardware, and exposes structured interfaces to higher-level frameworks. \
   chicdk: Camera hardware interface development kit delivering a configurable mechanism for use case selection and camera pipeline topology creation. \
   Includes configurable sensor and tuning binaries, which are essential for enabling full camera functionality."
LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://usr/share/doc/${BPN}/NO.LOGIN.BINARY.LICENSE.QTI.pdf;md5=7a5da794b857d786888bbf2b7b7529c8 \
                    file://usr/share/doc/${BPN}/NOTICE;md5=198d001f49d9a313355d5219f669a76c"

PBT_BUILD_DATE = "260203"
SRC_URI = " \
    https://qartifactory-edge.qualcomm.com/artifactory/qsc_releases/software/chip/component/camx.qclinux.0.0/${PBT_BUILD_DATE}/prebuilt_yocto/${BPN}_${PV}_armv8-2a.tar.gz;name=camxlib \
    https://qartifactory-edge.qualcomm.com/artifactory/qsc_releases/software/chip/component/camx.qclinux.0.0/${PBT_BUILD_DATE}/prebuilt_yocto/camx-lemans_${PV}_armv8-2a.tar.gz;name=camx \
    https://qartifactory-edge.qualcomm.com/artifactory/qsc_releases/software/chip/component/camx.qclinux.0.0/${PBT_BUILD_DATE}/prebuilt_yocto/chicdk-lemans_${PV}_armv8-2a.tar.gz;name=chicdk \
    https://qartifactory-edge.qualcomm.com/artifactory/qsc_releases/software/chip/component/camx.qclinux.0.0/${PBT_BUILD_DATE}/prebuilt_yocto/camxcommon-lemans_${PV}_armv8-2a.tar.gz;name=camxcommon \
    "

SRC_URI[camxlib.sha256sum] = "2e6a20530de17ffc506d20ca69149a02a2fd50c18990b3646f42c32f6fe42a7d"
SRC_URI[camx.sha256sum] = "38de86b36cfe58a37273e95e4ccea7d3243226f439fc79f7abd7a9103f7bee34"
SRC_URI[chicdk.sha256sum] = "91bb40b2fdc3e9816d99956efb2746b50f064e3b51661247bb28fc2d32045ef0"
SRC_URI[camxcommon.sha256sum] = "891c78465fb5ffb61a9dd48ba694b18c2523065a87749d1c173bba1cf663c46c"

S = "${UNPACKDIR}"

DEPENDS += "glib-2.0 fastrpc protobuf-camx libxml2"

# This package is currently only used and tested on ARMv8 (aarch64) machines.
# Therefore, builds for other architectures are not necessary and are explicitly excluded.
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"

# Disable configure and compile steps since this recipe uses prebuilt binaries.
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${datadir}/doc/${BPN}
    install -d ${D}${datadir}/doc/camx-lemans
    install -d ${D}${datadir}/doc/chicdk-lemans
    install -d ${D}${bindir}
    install -d ${D}/${sysconfdir}/camera/test/NHX/

    cp -r ${S}/usr/lib/* ${D}${libdir}
    cp -r ${S}/etc/camera/test/NHX/NHX.YUV_NV12_Prev_MaxRes.json ${D}/${sysconfdir}/camera/test/NHX/
    cp -r ${S}/usr/bin/* ${D}${bindir}

    # Remove unnecessary development symlinks (.so) from the staged image
    rm -f ${D}${libdir}/camx/lemans/*${SOLIBSDEV}
    rm -f ${D}${libdir}/camx/lemans/camera/components/*${SOLIBSDEV}
    rm -f ${D}${libdir}/camx/lemans/hw/*${SOLIBSDEV}
    rm -f ${D}${libdir}/camx/lemans/camera/*${SOLIBSDEV}

    install -m 0644 ${S}/usr/share/doc/${BPN}/NOTICE ${D}${datadir}/doc/${BPN}
    install -m 0644 ${S}/usr/share/doc/${BPN}/NO.LOGIN.BINARY.LICENSE.QTI.pdf ${D}${datadir}/doc/${BPN}

    install -m 0644 ${S}/usr/share/doc/camx-lemans/NOTICE ${D}${datadir}/doc/camx-lemans
    install -m 0644 ${S}/usr/share/doc/${BPN}/NO.LOGIN.BINARY.LICENSE.QTI.pdf ${D}${datadir}/doc/camx-lemans

    install -m 0644 ${S}/usr/share/doc/chicdk-lemans/NOTICE ${D}${datadir}/doc/chicdk-lemans
    install -m 0644 ${S}/usr/share/doc/${BPN}/NO.LOGIN.BINARY.LICENSE.QTI.pdf ${D}${datadir}/doc/chicdk-lemans
}

RPROVIDES:${PN} = "camxlib-monaco"
PACKAGE_BEFORE_PN += "camx-lemans chicdk-lemans camx-nhx"
RDEPENDS:${PN} += "chicdk-lemans"
RDEPENDS:${pn}-dev += "camxcommon-headers-dev"

FILES:camx-lemans = "\
    ${libdir}/libcamera_hardware_lemans*${SOLIBS} \
    ${libdir}/libcamxexternalformatutils_lemans*${SOLIBS} \
    ${libdir}/camx/lemans/hw/camera.qcom*${SOLIBS} \
    ${libdir}/camx/lemans/libcamera_hardware*${SOLIBS} \
    ${libdir}/camx/lemans/libcamxexternalformatutils*${SOLIBS} \
    ${libdir}/camx/lemans/libcom.qti.camx.chiiqutils*${SOLIBS} \
    ${libdir}/camx/lemans/libcom.qti.node.eisv*${SOLIBS} \
    "
FILES:chicdk-lemans = "\
    ${libdir}/camx/lemans/com.qti.feature2*${SOLIBS} \
    ${libdir}/camx/lemans/com.qualcomm*${SOLIBS} \
    ${libdir}/camx/lemans/libcommonchiutils*${SOLIBS} \
    ${libdir}/camx/lemans/libiccprofile*${SOLIBS} \
    ${libdir}/camx/lemans/com.qti.chiusecaseselector*${SOLIBS} \
    ${libdir}/camx/lemans/camera/components/com.qti.node*${SOLIBS} \
    ${libdir}/camx/lemans/camera/com.qti.sensormodule*${SOLIBS} \
    ${libdir}/camx/lemans/camera/*.bin \
    ${libdir}/camx/lemans/camera/com.qti.sensor*${SOLIBS} \
    ${libdir}/camx/lemans/hw/com.qti.chi.*${SOLIBS} \
    ${bindir}/camx \
    "
FILES:camx-nhx = "\
    ${bindir}/nhx.sh \
    ${sysconfdir}/camera/test/NHX/ \
    "
FILES:${PN} = "\
    ${libdir}/libcamera_metadata_lemans*${SOLIBS} \
    ${libdir}/camx/lemans/*${SOLIBS} \
    ${libdir}/camx/lemans/camera/components/com.qti.node.swregistration*${SOLIBS} \
    ${libdir}/camx/lemans/hw/*${SOLIBS} \
    ${libdir}/camx/lemans/camera/components/*${SOLIBS} \
    "
FILES:${PN}-dev = "\
    ${libdir}/*${SOLIBSDEV} \
    "
# Preserve ${PN} naming to avoid ambiguity in package identification.
DEBIAN_NOAUTONAME:${PN} = "1"
