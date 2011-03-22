DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

IMAGES_VERSION = "1"
BINARY_VERSION = "1"
BINARY_VERSION_bm750 = "6"
BINARY_VERSION_vuuno = "6"
BINARY_VERSION_vuultimo = "6"

PV = "${BINARY_VERSION}.${IMAGES_VERSION}"
PR = "r3"


SRC_URI = "file://bootlogo.mvi file://backdrop.mvi file://bootlogo_wait.mvi file://switchoff.mvi"
SRC_URI_append_vuuno = " file://splash_cfe_auto.bin"
SRC_URI_append_vuultimo = " file://splash_cfe_auto.bin"

S = "${WORKDIR}/"

MVI = "bootlogo backdrop bootlogo_wait"

do_install() {
	install -d ${D}/boot
	install -m 0755 ${S}/bootlogo-${MACHINE}-${BINARY_VERSION}.elf ${D}/boot/bootlogo.elf
	for i in ${MVI}; do
		install -m 0755 ${S}/$i-${MACHINE}-${IMAGES_VERSION}.mvi ${D}/boot/$i.mvi;
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

do_install_bm750() {
	install -d ${D}/boot
	install -d ${D}/usr/share
	for i in ${MVI}; do
		install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
		ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
	done;
}

do_install_vusolo() {
	install -d ${D}/boot
	install -d ${D}/usr/share
	for i in ${MVI}; do
		install -m 0755 ${S}/$i.mvi ${D}/usr/share/$i.mvi;
		ln -sf /usr/share/$i.mvi ${D}/boot/$i.mvi;
	done;
}

pkg_preinst() {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postinst() {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}

pkg_prerm() {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postrm() {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share"
