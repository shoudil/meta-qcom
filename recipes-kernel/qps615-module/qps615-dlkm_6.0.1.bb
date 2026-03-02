SUMMARY = "QPS615 PCIe Ethernet kernel module"
DESCRIPTION = "Kernel module for the QPS615 PCIe Ethernet \
bridge chip. Builds the host driver plus Qualcomm specific platform logic"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${S}/drivers/net/ethernet/toshiba/tc956x/LICENSE;md5=5cecbcf0c040b635e20026c75b838d63"

inherit module

SRCREV = "b65fb932d5bf6a8008e1f9b068e4a83b6999cb82"

SRC_URI = "\
	git://github.com/TC956X/TC9564_Host_Driver.git;protocol=https;branch=industrial_limited_tested;tag=V_06-00-01 \
	file://0001-net-ethernet-tc956x-Makefile-support-cross-build-via.patch \
	file://0002-net-ethernet-tc956x-read-MAC-address-from-DT-NVMEM-o.patch \
	file://0003-net-ethernet-tc956x-Replace-phylink-.validate-with-..patch \
	file://0004-net-ethernet-tc956x-Replace-strlcpy-with-strscpy-ker.patch \
	file://0005-net-ethernet-tc956x-Update-EEE-API-to-use-ethtool_ke.patch \
	file://0006-net-ethernet-tc956x-Use-kernel_ethtool_ts_info-kerne.patch \
	file://0007-net-ethernet-tc956x-Use-hrtimer_setup-kernel-6.15.patch \
	file://0008-net-ethernet-tc956x-Add-speed-argument-to-phy_loopba.patch \
	file://0009-net-ethernet-tc956x-Replace-phy_lookup_setting-with-.patch \
	file://0010-net-ethernet-tc956x-Use-kvfree-instead-of-vfree.patch \
	file://0011-net-ethernet-tc956x-Fix-module-auto-loading.patch \
	file://0012-net-ethernet-tc956x-Add-Qualcomm-platform-driver-and.patch \
"

B = "${S}/drivers/net/ethernet/toshiba/tc956x"

# The original Makefile uses an "ifeq ($(pf), 1)" check to pick the default config.
# Therefore, pf=1 needs to be set while compiling for non-SRIOV VF config.
EXTRA_OEMAKE += "KCFLAGS='-DTC956X -DCONFIG_TC956X_PLATFORM_SUPPORT -DTC956X_SRIOV_PF' pf=1"

