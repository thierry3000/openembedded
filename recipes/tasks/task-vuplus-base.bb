DESCRIPTION = "Vuplus: Base Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r6"

inherit task

#
# task-vuplus-base
#
DESCRIPTION_${PN} = "Vuplus: Basesystem utilities"

#  vuplus-feed-configs \
#  vuplus-keymaps \

VUPLUS_BASE_ESSENTIAL = "\
  autofs \
  base-files-doc \
  vuplus-bootlogo \
  vuplus-compat \
  vuplus-feed-configs \
  dreambox-keymaps \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  fakelocale \
  netkit-base \
  opkg-nogpg \
  timezones-alternative \
  tuxbox-common \
  util-linux-sfdisk \
  vsftpd \
  mtd-utils \
  hdparm \  
"

VUPLUS_BASE_RECOMMENDS = "\
  dropbear \
  vuplus-vucamd \
  sambaserver \
  openvpn \
  zeroconf \
"
VUPLUS_BASE_RECOMMENDS_append_vuuno = " vuplus-fpga-update"
VUPLUS_BASE_RECOMMENDS_append_vuultimo = " vuplus-fpga-update"

VUPLUS_BASE_OPTIONAL_RECOMMENDS = "\
  gdbserver \
  hddtemp \
  joe \
  mc \
  ncdu \
  ppp \
  smartmontools \
  avahi-daemon \
"

RDEPENDS_${PN} = "\
	${VUPLUS_BASE_ESSENTIAL} \
"

RRECOMMENDS_${PN} = "\
	${VUPLUS_BASE_RECOMMENDS} \
	${VUPLUS_BASE_OPTIONAL_RECOMMENDS} \
"

