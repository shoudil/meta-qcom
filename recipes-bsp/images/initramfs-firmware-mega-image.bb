DESCRIPTION = "Huge image with all firmware files. This is intended to check for possible conflicts, etc."

PACKAGE_INSTALL = " \
    linux-firmware \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

# Qualcomm Dragonboard / Robotics platforms
PACKAGE_INSTALL += " \
    packagegroup-dragonboard-apq8074-firmware \
    packagegroup-dragonboard410c-firmware \
    packagegroup-dragonboard820c-firmware \
    packagegroup-dragonboard845c-firmware \
    packagegroup-rb1-firmware \
    packagegroup-rb2-firmware \
    packagegroup-rb3gen2-firmware \
    packagegroup-rb5-firmware \
    packagegroup-dragonboard820c-hexagon-dsp-binaries \
    packagegroup-dragonboard845c-hexagon-dsp-binaries \
    packagegroup-rb1-hexagon-dsp-binaries \
    packagegroup-rb2-hexagon-dsp-binaries \
    packagegroup-rb3gen2-hexagon-dsp-binaries \
    packagegroup-rb5-hexagon-dsp-binaries \
"

# Qualcomm HDKs
PACKAGE_INSTALL += " \
    packagegroup-sm8150-hdk-firmware \
    packagegroup-sm8350-hdk-firmware \
    packagegroup-sm8450-hdk-firmware \
    packagegroup-sm8550-hdk-firmware \
    packagegroup-sm8650-hdk-firmware \
"

# Other Qualcomm DevKits
PACKAGE_INSTALL += " \
    packagegroup-qar2130p-firmware \
"

require initramfs-firmware-image.inc
