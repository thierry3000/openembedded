DESCRIPTION = "lcd4linux support for duo2"
LICENSE = "GPLv2"

RDEPENDS = "enigma2 png-util"

SRC_URI = " \
        file://plugin.py \
"

S = "${WORKDIR}"

PR = "r0"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/LCD4linuxSupport"

do_install() {
        install -d  ${D}${PLUGINPATH}
        install -m 0600 ${S}/plugin.py ${D}${PLUGINPATH}
	touch ${D}${PLUGINPATH}/__init__.py
}

FILES_${PN} = "${PLUGINPATH}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

