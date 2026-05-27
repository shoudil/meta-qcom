DESCRIPTION = "QCOM NHLOS Firmware for Qualcomm GLYMUR-CRD platform"
LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE.${BPN};md5=6e1bae7ef13289c332a27b917fb49764"

FW_ARTIFACTORY = "softwarecenter.qualcomm.com/nexus/generic/product/chip/tech-package/Glymur_bootbinaries.1.0/glymur_bootbinaries.1.0-test-device-public"
BOOTBINARIES = "Glymur_bootbinaries"

S = "${UNPACKDIR}/${BOOTBINARIES}/spinor"

SRC_URI = " \
    https://${FW_ARTIFACTORY}/${PV}/${BOOTBINARIES}_${PV}.zip;name=bootbinaries \
    https://${FW_ARTIFACTORY}/${PV}/LICENSE.txt;downloadfilename=LICENSE.${BPN};name=license \
    https://artifacts.codelinaro.org/artifactory/codelinaro-le/Qualcomm_Linux/SC8480XP/cdt/sc8480xp-crd.zip;downloadfilename=sc8480xp-crd_${PV}.zip;name=sc8480xp-crd \
    "
SRC_URI[license.sha256sum] = "3ad8f1fd82f2918c858cec2d0887b7df6f71a06416beecfdb3efe7d62874d863"
SRC_URI[sc8480xp-crd.sha256sum] = "d694eedb0addcc5ee588d6993661cd23996fba1d1a43afc3b196dad12534bffc"

QCOM_BOOT_IMG_SUBDIR = "glymur-crd/spinor"

include firmware-qcom-boot-common.inc
