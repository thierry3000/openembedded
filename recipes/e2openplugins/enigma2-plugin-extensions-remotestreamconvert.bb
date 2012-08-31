MODULE = "RemoteChannelStreamConverter"
DESCRIPTION = "Fetch channels from remote bouquets and make them available locally"

RDEPENDS_${PN} = "python-shell"

PR="r0"

require openplugins.inc

require assume-gplv2.inc

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"

do_install() {
        install -d ${D}${PLUGINPATH}
        cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"
PACKAGES = ${PN}
