FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:qcom = " \
    file://0001-gl-shaders-Remove-asserts-relying-on-shader-compiler.patch \
"
