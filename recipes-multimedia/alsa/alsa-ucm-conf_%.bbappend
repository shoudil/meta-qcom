FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:qcom = " \
    file://0001-ucm2-da7213-Add-ADC-switch-in-HeadphoneMic2-sequence.patch \
"