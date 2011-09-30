DESCRIPTION = "arora webbrowser binary"
PV = "0.10.1"
PR = "r2"

DEPENDS = "qtwebkit-e"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-webbrowser-utils_${PR}.tar.bz2"

S = "${WORKDIR}/vuplus-webbrowser-utils"

do_install() {
	install -d ${D}/${bindir};
	install -m 0755 arora ${D}/${bindir};
}
