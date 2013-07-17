DESCRIPTION = "Linux kernel for vuplus"
LICENSE = "GPL"

KV = "3.3.8"

SRCREV = ""

MODULE = "linux-3.3.8"

SRC_URI += "http://archive.vuplus.com/download/kernel/stblinux-3.3.6-2.0.tar.bz2 \
        file://brcm_3.3.patch;patch=1;pnum=1 \
        file://brcm_mtd_mac.patch;patch=1;pnum=1 \
        file://dvb_core_5.5.patch;patch=1;pnum=1 \
        file://dvb_backport.patch;patch=1;pnum=1 \
        file://${MACHINE}_defconfig \
	"

S = "${WORKDIR}/linux"

inherit kernel

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

FILES_kernel-image = "/${KERNEL_IMAGEDEST}/vmlinux.gz /${KERNEL_IMAGEDEST}/autoexec.bat"

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
                flash_erase /dev/mtd2 0 0
                nandwrite -p /dev/mtd2 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        true
}

