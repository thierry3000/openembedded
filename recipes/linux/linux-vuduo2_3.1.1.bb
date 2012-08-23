DESCRIPTION = "Linux kernel for vuplus duo2"
LICENSE = "GPL"
KV = "3.1.1"

SRCREV = "r0"

MODULE = "linux-3.1.1"

SRC_URI += "file://stblinux-2.6.37-2.8.tar.bz2 \
	file://dvb-core.patch;patch=1;pnum=1 \
	file://pinmux.patch;patch=1;pnum=1 \
	file://debug.patch;patch=1;pnum=1 \
	file://fix_cpu_proc.patch;patch=1;pnum=1 \
	file://brcm_disable_enet1.patch;patch=1;pnum=1 \
	file://brcm_nand_timing.patch;patch=1;pnum=1 \
	file://${MACHINE}_defconfig \
        "

S = "${WORKDIR}/stblinux-2.6.37"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"


do_configure_prepend() {
        oe_machinstall -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${S}/.config
        oe_runmake oldconfig
}

kernel_do_install_append() {
        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
        gzip ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                flash_eraseall -j /dev/mtd1
                nandwrite -p /dev/mtd1 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        true
}

