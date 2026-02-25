SUMMARY = "Packages for the OP-TEE support"

inherit packagegroup

RRECOMMENDS:${PN} = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'optee-os-tadevkit optee-client optee-test', '', d)} \
"
