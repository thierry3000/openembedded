DESCRIPTION = "opera-hbbtv"
PRIORITY = "required"
PR = "r0"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "file://opera-hbbtv.tar.gz"
S = "${WORKDIR}/opera-hbbtv"

do_compile() {
}

do_install() {
        install -d ${D}/usr/local/hbb-browser
	mv ${S}/* ${D}/usr/local/hbb-browser/
}

FILES_${PN} = "/"

