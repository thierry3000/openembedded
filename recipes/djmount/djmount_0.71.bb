DESCRIPTION = "mount UPnP server content as a linux filesystem"
HOMEPAGE = "http://djmount.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "libupnp fuse"
RDEPENDS_${PN} = "fuse-utils fuse"
PR = "r2"

inherit autotools

EXTRA_OECONF = "--with-external-libupnp --with-fuse-prefix='/usr/lib/'"

SRC_URI = "${SOURCEFORGE_MIRROR}/djmount/djmount-0.71.tar.gz \
	file://filebuffer-fix_range.patch;patch=1"

do_configure() {
	cd ${S}
	oe_runconf
}

