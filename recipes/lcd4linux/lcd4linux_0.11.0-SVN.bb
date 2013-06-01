DESCRIPTION = "LCD4Linux is a small program that grabs information from the kernel and some subsystems and displays it on an external liquid crystal display."
LICENSE = "GPLv2"

DEPENDS = "virtual/libusb0 ncurses readline virtual/libx11"
DEPENDS_vuplus = "libusb ncurses readline jpeg"
RDEPENDS_vuplus = "jpeg"

PV = "0.11.0-SVN"
PR = "r2"

EXTRA_OECONF = " --with-glib-prefix=${STAGING_LIBDIR}/.. \
		--with-glib-exec-prefix=${STAGING_LIBDIR}/.. \
		--with-ncurses=${STAGING_LIBDIR}/.."
SRC_URI = " http://ssl.bulix.org/projects/lcd4linux/raw-attachment/wiki/Download/lcd4linux-0.11.0-SVN.tar.bz2 \
           file://lcd4linux.init"

S =  "${WORKDIR}/lcd4linux-0.11.0-SVN"

SRC_URI_vuplus = "svn://ssl.bulix.org/svn/lcd4linux/;module=trunk;proto=https;rev=1200 \
		file://lcd4linux.init \
"

S_vuplus =  "${WORKDIR}/trunk"

addtask setlibtool before do_configure after do_patch

do_setlibtool (){
}

do_setlibtool_vuplus (){
	sed -i "s#LIBTOOL=libtool#LIBTOOL=\${STAGING_BINDIR_NATIVE}\/\${HOST_SYS}-libtool#" ${S}/Makefile.am
}


INITSCRIPT_PARAMS_vuplus = "stop 10 0 6 ."
inherit autotools update-rc.d

INITSCRIPT_NAME = "lcd4linux"
CONFFILES_${PN} += "${sysconfdir}/lcd4linux.conf"

do_install_append() {
	install -d ${D}/${sysconfdir}
	install -m 0600 ${S}/lcd4linux.conf.sample  ${D}/${sysconfdir}/lcd4linux.conf
	install -d ${D}/${INIT_D_DIR}
	install -m 0755 ${WORKDIR}/lcd4linux.init ${D}/${INIT_D_DIR}/lcd4linux
}

