DESCRIPTION = "Linux kernel for vuplus ultimo"
LICENSE = "GPL"
KV = "2.6.18-7.3"
PV = "2.6.18"
PR = "r7"

MODULE = "stblinux-2.6.18"


SRC_URI_GCC44_PATCH = ${@base_contains('PREFERRED_GCC_VERSION', '4.4.3', 'file://linux_vuultimo_gcc_4.4.patch;patch=1;pnum=1', '', d)}


SRC_URI = "http://archive.vuplus.com/download/stblinux-${KV}.tar.bz2 \
	file://linux_vuultimo_nand2.patch;patch=1;pnum=1 \
        file://linux_vuultimo_proc.patch;patch=1;pnum=0 \
        file://linux_vuultimo_serial.patch;patch=1;pnum=0 \
        file://linux_vuultimo_resource.patch;patch=1;pnum=0 \
        file://linux_vuultimo_arch_makefile.patch;patch=1;pnum=0 \
        file://linux_vuultimo_kobject.patch;patch=1;pnum=0 \
        file://linux-2.6.18-dvb-frontends.patch;patch=1;pnum=0 \
        file://linux-2.6.18-dvb-core2.patch;patch=1;pnum=0 \
        file://dvb-include-2.6.18-5.3.patch;patch=1;pnum=0 \
	file://vuultimo_defconfig \
	"

SRC_URI += ${SRC_URI_GCC44_PATCH}

S = "${WORKDIR}/stblinux-2.6.18"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"


do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/vuultimo_defconfig ${S}/.config
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p0 < ${S}/fs/cdfs/patch.cdfs
	fi;
	oe_runmake oldconfig
}

do_install_append () {
        install -d ${D}/boot
        install -m 0755 vmlinux ${D}/boot/vmlinux
        gzip ${D}/boot/vmlinux
}

pkg_preinst_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
	true
	if [ -f /boot/vmlinux.gz ];
	then rm -f /boot/vmlinux.gz;
	fi
}

pkg_postinst_kernel-image () {
	if [ -d /proc/stb ];
	then flash_eraseall /dev/mtd1; nandwrite /dev/mtd1 /boot/vmlinux.gz -p;
	fi
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true

}

pkg_prerm_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
	true
}

pkg_postrm_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true
}
