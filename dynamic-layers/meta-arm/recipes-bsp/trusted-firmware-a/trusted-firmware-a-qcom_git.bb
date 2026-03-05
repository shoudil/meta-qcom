require recipes-bsp/trusted-firmware-a/trusted-firmware-a.inc

PV = "2.14.0-qcom+git"

SRC_URI = "git://github.com/qualcomm-linux/trusted-firmware-a.git;protocol=https;name=tfa;branch=qcom-next"
SRCREV_tfa = "78d883ea408d58786287102bc704a5bfce2cbd90"

require trusted-firmware-a-qcom.inc
