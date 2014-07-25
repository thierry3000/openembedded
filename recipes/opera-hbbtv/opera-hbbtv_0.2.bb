DESCRIPTION = "opera-hbbtv"
LICENSE = "proprietary"

PRIORITY = "required"

SRC_DATE = "20140725_0"

DEPENDS = "jpeg"
RDEPENS = "sysfsutils vuplus-dvb-modules"

PR = "r1_${SRC_DATE}"
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
	install -d ${D}/usr/lib
	mv ${S}/dfb/usr/lib/* ${D}/usr/lib/
}

package_do_shlibs_append() {
        deps_path = d.getVar('PKGDEST', True)
        deps = deps_path + "/opera-hbbtv.shlibdeps"
        tmp = "/tmp/.opera-hbbtv.shlibdeps"
        os.system("sed -e '/vbrowser/d' %s > %s" % (deps, tmp))
        os.system("cp %s %s" % (tmp, deps))
}

do_package_qa() {
}

sysroot_stage_all() {
}

PACKAGES = ${PN}

FILES_${PN} = "/"

