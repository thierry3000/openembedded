DESCRIPTION = "lcd4linux plugin for duo2"
LICENSE = "GPLv2"

SRC_URI = " \
        file://LCD4linux.tar.gz \
"

RDEPENDS = python-codecs python-datetime python-textutils python-imaging

S = "${WORKDIR}/LCD4linux"

PR = "r0"

do_install() {
        install -d  ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux
        install -m 0755 ${S}/*.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/
        install -m 0755 ${S}/*.png ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux
        install -m 0755 ${S}/*.conf ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux
        install -m 0755 ${S}/*.so ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux
        install -m 0755 ${S}/*.pot ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux
        install -d  ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/locale/de/LC_MESSAGES
        install -m 0644 ${S}/locale/de/LC_MESSAGES/LCD4linux.mo ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/locale/de/LC_MESSAGES
        install -d  ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/wetter
        install -m 0755 ${S}/wetter/*.gif ${D}/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/wetter
}

FILES_${PN} = "/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux"

PACKAGE_ARCH = "${MACHINE_ARCH}"
