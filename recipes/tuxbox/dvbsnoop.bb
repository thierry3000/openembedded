DEPENDS = "dreambox-dvbincludes"
DESCRIPTION = "DVBsnoop by rasc@users.sourceforge.net"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_REV = "f120ec1ab0469b0dc3944adf7c5950c0bbef0832"

SRC_URI = "git://git.code.sf.net/p/tuxbox-cvs/apps;protocol=git;tag=${SRC_REV} \
           file://acinclude.m4"
	   
PR = "r2"
S = "${WORKDIR}/git/dvb/dvbsnoop"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=cdk"
