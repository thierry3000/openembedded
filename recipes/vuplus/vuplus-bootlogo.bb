DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

IMAGES_VERSION = "1"
BINARY_VERSION = "7"

PV = "${BINARY_VERSION}.${IMAGES_VERSION}"
PR = "r7"

KERNEL_VERSION = "${@base_contains('PREFERRED_VERSION_linux-${MACHINE}', '2.6.18', '2.6.18', '3.1.1', d)}"

SRC_URI = "file://bootlogo.mvi file://backdrop.mvi file://bootlogo_wait.mvi file://switchoff.mvi"
SRC_URI_append_vuuno = " file://splash_cfe_auto.bin"
SRC_URI_append_vuultimo = " file://splash_cfe_auto.bin"
SRC_URI_append_vuduo2 = " file://initrd_cfe_auto.bin file://splash_cfe_auto.bin"
SRC_URI_append_vusolo2 = " file://initrd_cfe_auto.bin file://splash_cfe_auto.bin"

S = "${WORKDIR}/"

MVI = "bootlogo backdrop bootlogo_wait"

do_install() {
	install -d ${D}/boot
	install -d ${D}/usr/share
	for i in ${MVI}; do
		install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
		ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
	done;
}

do_install_vuuno() {
	install -d ${D}/boot
        install -d ${D}/usr/share
        for i in ${MVI}; do
                install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
                ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
        done;
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}
do_install_vuultimo() {
        install -d ${D}/boot
        install -d ${D}/usr/share
        for i in ${MVI}; do
                install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
                ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
        done;
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}
do_install_vuduo2() {
	install -d ${D}/boot
        install -d ${D}/usr/share
        for i in ${MVI}; do
                install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
                ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
        done;
        install -m 0755 ${S}/initrd_cfe_auto.bin ${D}/boot/initrd_cfe_auto.bin
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}
do_install_vusolo2() {
	install -d ${D}/boot
        install -d ${D}/usr/share
        for i in ${MVI}; do
                install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
                ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
        done;
        install -m 0755 ${S}/initrd_cfe_auto.bin ${D}/boot/initrd_cfe_auto.bin
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}

pkg_preinst() {
	if [ "${KERNEL_VERSION}" = "2.6.18" ]; then
		[ -d /proc/stb ] && mount -o rw,remount /boot
	fi
}

pkg_postinst() {
	if [ "${KERNEL_VERSION}" = "2.6.18" ]; then
		[ -d /proc/stb ] && mount -o ro,remount /boot
	fi
}

pkg_prerm() {
	if [ "${KERNEL_VERSION}" = "2.6.18" ]; then
		[ -d /proc/stb ] && mount -o rw,remount /boot
	fi
}

pkg_postrm() {
	if [ "${KERNEL_VERSION}" = "2.6.18" ]; then
		[ -d /proc/stb ] && mount -o ro,remount /boot
	fi
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share"
