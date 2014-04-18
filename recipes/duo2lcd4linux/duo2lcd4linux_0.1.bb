DESCRIPTION = "lcd4linux plugin for duo2"
LICENSE = "GPLv2"

SRC_URI = " \
        file://LCD4linux.tar.gz \
        file://wetter.tar.gz \
	file://duo2lcd4linux.patch;patch=1;pnum=1 \
	file://duo2lcd4linux-fix-standby.patch;patch=1;pnum=1 \
"

RDEPENDS = "enigma2 python-codecs python-datetime python-imaging python-textutils python-shell python-ctypes python-pyusb lcd4linux"

S = "${WORKDIR}/LCD4linux"

PR = "r4"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux"

do_install() {
        install -d  ${D}${PLUGINPATH}
        install -m 0600 ${S}/*.* ${D}${PLUGINPATH}
        install -m 0600 ${S}/refreshrate ${D}${PLUGINPATH}
        install -d  ${D}${PLUGINPATH}/locale/de/LC_MESSAGES
        install -m 0600 ${S}/locale/de/LC_MESSAGES/* ${D}${PLUGINPATH}/locale/de/LC_MESSAGES
        install -d  ${D}${PLUGINPATH}/wetter
        install -m 0600 ${S}/wetter/* ${D}${PLUGINPATH}/wetter
}

FILES_${PN} = "${PLUGINPATH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

