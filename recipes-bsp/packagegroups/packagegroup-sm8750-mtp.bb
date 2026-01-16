SUMMARY = "Packages for the SM8750-MTP platform"

inherit packagegroup

PACKAGES = " \
    ${PN}-firmware \
    ${PN}-hexagon-dsp-binaries \
"

RRECOMMENDS:${PN}-firmware = " \
    ${@bb.utils.contains_any('DISTRO_FEATURES', 'opencl opengl vulkan', 'linux-firmware-qcom-adreno-g800 linux-firmware-qcom-sm8750-adreno', '', d)} \
    linux-firmware-qcom-sm8750-audio \
    linux-firmware-qcom-sm8750-compute \
    linux-firmware-qcom-vpu \
"

RDEPENDS:${PN}-hexagon-dsp-binaries = " \
    hexagon-dsp-binaries-qcom-sm8750-mtp-adsp \
    hexagon-dsp-binaries-qcom-sm8750-mtp-cdsp \
"
