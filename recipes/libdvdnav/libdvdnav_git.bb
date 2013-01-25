# libdvdnav.bb build file
HOMEPAGE="http://git.debian-maintainers.org/"
DESCRIPTION="DVD navigation multimeda library"
LICENSE = "GPL"
DEPENDS = "libdvdread"
RDEPENDS = "libdvdread"

PR = "r9"

#debian/4.1.3-7
SRCREV="8f2cefe14027e98bb29a8ce69ad06adecf894c17"

EXTRA_OECONF = "--with-dvdread-prefix=${STAGING_LIBDIR}/.."

SRC_URI = "git://sources.progress-linux.org/git/users/daniel/packages/libdvdnav.git;protocol=git;branch=debian;tag=${SRCREV} "

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_munge() {
	for i in `ls debian/patches | grep ".patch" | sort -n`; do
		oenote "Applying debian patch '$i'";
		patch -p1 < debian/patches/$i;
	done;
}

addtask munge before do_compile after do_patch

do_stage() {
	autotools_stage_all
}
