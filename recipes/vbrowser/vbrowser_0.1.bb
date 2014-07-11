DESCRIPTION = "vbrowser"
LICENSE = "proprietary"

PRIORITY = "required"

SRC_DATE = "20140711_0"

RDEPENS = "sysfsutils vuplus-dvb-modules"

PR = "r1_${SRC_DATE}"
SRC_URI = ""

INHIBIT_PACKAGE_STRIP = "1"
S = "${WORKDIR}/vbrowser"

SRC_FILE = "vbrowser_${SRC_DATE}.tar.gz"
do_fetch() {
	if [ ! -e ${DL_DIR}/${SRC_FILE} -a -e /etc/vuplus_browser.pwd ]; then
sshpass -f /etc/vuplus_browser.pwd sftp -o StrictHostKeyChecking=no guestuser@code.vuplus.com << +
get ${SRC_FILE}
bye
+
	fi
	cp -av ${DL_DIR}/${SRC_FILE} ${WORKDIR}/
}

do_unpack() {
	tar xvfz ${SRC_FILE}
}

do_compile() {
}

do_install() {
	install -d ${D}/usr/local/vbrowser
	mv ${S}/* ${D}/usr/local/vbrowser/
}

do_package_qa() {
}

PACKAGES = ${PN}

FILES_${PN} = "/"

