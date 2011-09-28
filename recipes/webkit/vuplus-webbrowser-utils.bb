DESCRIPTION = "arora webbrowser binary"
PV = "0.10.1"
PR = "r0"

DEPENDS = "qtwebkit-e"

SRC_URI = "file://arora"

S = "${WORKDIR}/vuplus-webbrowser-utils"

do_configure() {
	mv ${WORKDIR}/arora ${S}
}

do_install() {
	install -d ${D}/${bindir};
	install -m 0755 arora ${D}/${bindir};
}
