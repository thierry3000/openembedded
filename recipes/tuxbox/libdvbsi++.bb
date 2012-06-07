DESCRIPTION = "libdvbsi++ by obi@saftware.de"
DEPENDS = "dreambox-dvbincludes"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "git://git.opendreambox.org/git/obi/libdvbsi++.git;protocol=git"

SRCREV = "49b0c78a0b0db3efd0a49c4cf2fc1c7f4bf21c15"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}

EXTRA_OECONF = "--with-target=native"
