require recipes-security/optee/optee-os.inc

PV = "4.9.0-qcom+git"

SRC_TAG = "tag=4.9.0"
SRC_URI = "git://github.com/qualcomm-linux/optee_os.git;protocol=https;name=optee;nobranch=1;${SRC_TAG}"
SRCREV_optee = "c2b0684fcd89929976a8726e6e3af922b48dd2c7"

require optee-qcom.inc
