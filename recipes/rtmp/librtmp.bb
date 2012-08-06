DESCRIPTION = "librtmp Real-Time Messaging Protocol API"
LICENSE = "LGPL"

DEPENDS = "openssl"

inherit gitpkgv

PKGV = "2.4+git${GITPKGV}"
PV = "2.4+git${SRCPV}"
PR = "r2"

BRANCH=""
SRCREV="7340f6dbc6b3c8e552baab2e5a891c2de75cddcc"

SRC_URI = "git://git.ffmpeg.org/rtmpdump;protocol=git;branch=${BRANCH};tag=${SRCREV}"

S = "${WORKDIR}/git/librtmp"

do_compile() {
	oe_runmake CROSS_COMPILE=${TARGET_PREFIX} CFLAGS="${CFLAGS} -fPIC" LDFLAGS="${LDFLAGS}"
}

do_install() {
	oe_runmake DESTDIR=${D} install
}
