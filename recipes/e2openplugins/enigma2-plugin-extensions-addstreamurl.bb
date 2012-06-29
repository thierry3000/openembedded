MODULE = "AddStreamUrl"
DESCRIPTION = "Add a stream url to your channellist"

PR="r0"

require openplugins.inc

require assume-gplv2.inc

SRC_URI += "file://addstreamurl_uifix.patch;patch=1;pnum=1"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"

do_install() {
        install -d ${D}${PLUGINPATH}
        cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"
PACKAGES = ${PN}
