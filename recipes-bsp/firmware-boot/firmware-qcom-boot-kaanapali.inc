DESCRIPTION = "QCOM NHLOS Firmware for Qualcomm Kaanapali-MTP platform"
LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE.${BPN};md5=6e1bae7ef13289c332a27b917fb49764"

FW_ARTIFACTORY = "softwarecenter.qualcomm.com/nexus/generic/product/chip/software-product-family/Qualcomm_Linux.SPF.0.0/qualcomm_linux.spf.0.0-test-device-public"
FW_BUILD_ID = "r0.0_${PV}/KAANAPALI.LE.0.0"
FW_BIN_PATH = "common/build/ufs/bin"
BOOTBINARIES = "kaanapali_bootbinaries"

SRC_URI = " \
    https://${FW_ARTIFACTORY}/${FW_BUILD_ID}/${FW_BIN_PATH}/${BOOTBINARIES}.zip;downloadfilename=${BOOTBINARIES}_r0.0_${PV}.zip;name=bootbinaries \
    https://${FW_ARTIFACTORY}/${FW_BUILD_ID}/LICENSE.txt;downloadfilename=LICENSE.${BPN};name=license \
    https://artifacts.codelinaro.org/artifactory/codelinaro-le/Qualcomm_Linux/SM8850/cdt/sm8850-mtp.zip;downloadfilename=sm8850-mtp_${PV}.zip;name=sm8850-mtp \
    "
SRC_URI[license.sha256sum] = "3ad8f1fd82f2918c858cec2d0887b7df6f71a06416beecfdb3efe7d62874d863"
SRC_URI[sm8850-mtp.sha256sum] = "41b15acaa06311c8c7500d7467a5d8adb9fdee05aed09d983d3dad045865b1d7"

QCOM_BOOT_IMG_SUBDIR = "kaanapali"

include firmware-qcom-boot-common.inc
