HOMEPAGE = "http://www.alumnit.ca/wiki/?WvDial"
DESCRIPTION = "WvDial is a program that makes it easy to connect your Linux workstation to the Internet."

PR = "r3"

LICENSE = "LGPL"
SRC_URI = "\
	http://www.alumnit.ca/download/wvdial-1.60.tar.gz \
	file://wvdial-vuplus_001.patch;patch=1 \
	"

DEPENDS = "wvstreams"
RDEPENDS = "ppp"

EXTRA_OEMAKE = ""
export CC="${CXX}"

do_install() {
    oe_runmake prefix=${D}/usr PPPDIR=${D}/etc/ppp/peers install
}
