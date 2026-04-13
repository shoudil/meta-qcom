require recipes-bsp/trusted-firmware-a/trusted-firmware-a.inc

PV = "2.14.0-qcom+git"

SRC_TAG = "tag=qcom-next-2.14-20260220"
SRC_URI = "git://github.com/qualcomm-linux/trusted-firmware-a.git;protocol=https;name=tfa;nobranch=1;${SRC_TAG}"
SRCREV_tfa = "78d883ea408d58786287102bc704a5bfce2cbd90"

require trusted-firmware-a-qcom.inc
