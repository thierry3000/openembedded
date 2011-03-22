require linux-opendreambox-2.6.18.inc

PR="${PR_INC}.0"

RDEPENDS += "dreambox-secondstage (>=83)"

SRC_URI += "\
	file://linux-2.6.18-disable-unneeded-uarts.patch;patch=1 \
	file://linux-2.6.18-dm8000-nand-smp-fix.patch;patch=1 \
	file://linux-2.6.18-use-full-flash.patch;patch=1 \
	file://linux-2.6.18-big-summary.patch;patch=1 \
"

pkg_preinst_kernel-image_dm8000 () {
	if [ -d /proc/stb ] && `mount -o rw,remount /boot`; then
		if [ ! -f /boot/secondstage.conf ] || [ `grep "legacy_flash_mapping" /boot/secondstage.conf | wc -l` -eq 0 ]; then
			echo "enable legacy flash mapping in secondstage.conf";
			echo "legacy_flash_mapping=1;" > /boot/secondstage.conf;
		fi;
	fi;
	true;
}