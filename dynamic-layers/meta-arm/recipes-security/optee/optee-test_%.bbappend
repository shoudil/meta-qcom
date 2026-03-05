# Machine specific configurations

MACHINE_OPTEE_REQUIRE ?= ""
MACHINE_OPTEE_REQUIRE:qcom = "optee-qcom.inc"

require ${MACHINE_OPTEE_REQUIRE}
