DESCRIPTION = "opera-hbbtv"
PRIORITY = "required"

SRC_DATE = "20130114_2"

PR = "r0_${SRC_DATE}"
SRC_URI = "http://code.vuplus.com/download/build.fc3abf29fb03f797e78f907928125638/embedded/opera-sdk-build-package/opera-hbbtv_${SRC_DATE}.tar.gz"

INHIBIT_PACKAGE_STRIP = "1"
S = "${WORKDIR}/opera-hbbtv"
do_compile() {
}
do_install() {
        install -d ${D}/usr/local/hbb-browser
	mv ${S}/opera/* ${D}/usr/local/hbb-browser/
        install -d ${D}/etc
	mv ${S}/dfb/etc/* ${D}/etc/
        install -d ${D}/usr/bin
	mv ${S}/dfb/usr/bin/* ${D}/usr/bin/
        install -d ${D}/usr/lib
	mv ${S}/dfb/usr/lib/* ${D}/usr/lib/
        install -d ${D}/usr/share
	mv ${S}/dfb/usr/share/* ${D}/usr/share/
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/HbbTV
	mv ${S}/plugin/* ${D}/usr/lib/enigma2/python/Plugins/Extensions/HbbTV
}

PACKAGES = ${PN}

FILES_${PN} = "/"

