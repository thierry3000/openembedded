DESCRIPTION = "Driver for Ralink RT8070/RT3070/RT3370 USB 802.11abgn WiFi sticks"
SECTION = "kernel/modules"
LICENSE = "GPL"
SRCNAME = "rt3070"

inherit module

PR = "r2"

SRC_URI = "file://2011_0719_RT3070_RT3370_RT5370_RT5372_Linux_STA_V2.5.0.3_DPO.tar.bz2 \
		file://makefile_2.5.0.3.patch;patch=1 \
		file://config_2.5.0.3.patch;patch=1 \
		file://change_device_name_wlan_from_ra.patch;patch=1 \
	"

S = "${WORKDIR}/2011_0719_RT3070_RT3370_RT5370_RT5372_Linux_STA_V${PV}_DPO"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 ${S}/*sta${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	touch ${D}${sysconfdir}/modprobe.d/blacklist-wlan.conf
	echo "blacklist rt2800usb" >> ${D}${sysconfdir}/modprobe.d/blacklist-wlan.conf
	echo "blacklist rt2800lib" >> ${D}${sysconfdir}/modprobe.d/blacklist-wlan.conf

}

PACKAGE_ARCH = "${MACHINE_ARCH}"

