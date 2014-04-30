DESCRIPTION = "opera-hbbtv"
LICENSE = "proprietary"

PRIORITY = "required"

SRC_DATE = "20140430_0"

DEPENDS = "jpeg"
RDEPENS = "vuplus-dvb-modules"

PR = "r3_${SRC_DATE}"
SRC_URI = ""

INHIBIT_PACKAGE_STRIP = "1"
S = "${WORKDIR}/opera-hbbtv"

SRC_FILE = "opera-hbbtv_${SRC_DATE}.tar.gz"
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

do_package_qa() {
}

PACKAGES = ${PN}

FILES_${PN} = "/"

