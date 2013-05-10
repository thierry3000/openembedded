DESCRIPTION = "lcd4linux plugin for duo2"
LICENSE = "GPLv2"

SRC_URI = " \
        file://LCD4linux.tar.gz \
	file://duo2lcd4linux.patch;patch=1;pnum=1 \
"

RDEPENDS = "python-codecs python-datetime python-textutils python-imaging png-util"

S = "${WORKDIR}/LCD4linux"

PR = "r2"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/LCD4linux"

do_install() {
        install -d  ${D}${PLUGINPATH}
        install -m 0755 ${S}/*.py ${D}${PLUGINPATH}
        install -m 0755 ${S}/*.png ${D}${PLUGINPATH}
        install -d  ${D}${PLUGINPATH}/locale/de/LC_MESSAGES
        install -m 0644 ${S}/locale/de/LC_MESSAGES/LCD4linux.mo ${D}${PLUGINPATH}/locale/de/LC_MESSAGES
        install -d  ${D}${PLUGINPATH}/wetter
        install -m 0755 ${S}/wetter/*.gif ${D}${PLUGINPATH}/wetter
}

FILES_${PN} = "${PLUGINPATH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

