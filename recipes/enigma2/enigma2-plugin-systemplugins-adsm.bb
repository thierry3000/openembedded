DESCRIPTION = "Automatically Deep Standby Manager Plugins"
SECTION  = "base"
PRIORITY = "optional"
LICENSE  = "proprietary"

DEPENDS  = "enigma2"

PR = "r0"
PV = "20121113.3"

SRC_URI = "http://code.vuplus.com/download/build.fc3abf29fb03f797e78f907928125638/embedded/adsm/vuplus_enigma2_adsm_${PV}.tar.gz"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/ADSM"

S = "${WORKDIR}/adsm"

do_compile() {
}

do_install() {
        install -d  ${D}/${PLUGINPATH}
        install -m 0644 ${S}/__init__.py ${D}/${PLUGINPATH}
        install -m 0644 ${S}/plugin.py ${D}/${PLUGINPATH}
        install -m 0644 ${S}/helper.py ${D}/${PLUGINPATH}
        install -m 0644 ${S}/singleton.py ${D}/${PLUGINPATH}
        install -m 0644 ${S}/keymap.xml ${D}/${PLUGINPATH}
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "${PLUGINPATH}"
PACKAGES = "${PN}"

PROVIDES="${PACKAGES}"

SRC_URI[md5sum] = "cee7c2960b3d652036dd804b99dc2c25"
SRC_URI[sha256sum] = "d6a997d687126d217a2e64b58d7ebab31ffb3a49910d9295c11801a9fdfd0241"

