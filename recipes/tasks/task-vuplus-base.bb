DESCRIPTION = "Vuplus: Base Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r12"

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
  mkfs-ubifs \
  mkfs-jffs2 \
  hdparm \  
  usbtunerhelper \
  openresolv \
  \
  firmware-dvb-af9005 \
  firmware-dvb-fe-af9013 \
  firmware-dvb-usb-af9015 \
  firmware-dvb-usb-af9035 \
  firmware-dvb-usb-avertv-a800 \
  firmware-dvb-usb-dib0700 \
  firmware-dvb-usb-dibusb \
  firmware-dvb-usb-digitv \
  firmware-dvb-usb-nova-t-usb2 \
  firmware-dvb-usb-sms1xxx-nova-dvbt \
  firmware-dvb-usb-sms1xxx-hcw-dvbt \
  firmware-dvb-usb-ttusb-budget \
  firmware-dvb-usb-umt-010 \
  firmware-dvb-usb-xc5000 \
  firmware-dvb-usb-wt220u-zl0353 \
  firmware-drxd-a2 \
"

VUPLUS_BASE_ESSENTIAL_append_vusolo2 = " procps"

VUPLUS_BASE_RECOMMENDS = "\
  dropbear \
  vuplus-vucamd \
  sambaserver \
  openvpn \
  zeroconf \
"
VUPLUS_BASE_RECOMMENDS_append_vuuno = " vuplus-fpga-update"
VUPLUS_BASE_RECOMMENDS_append_vuultimo = " vuplus-fpga-update"

#VUPLUS_BASE_RECOMMENDS_append_vuduo2 = " vuplus-manual"
VUPLUS_BASE_RECOMMENDS_append_vusolo2 = " vuplus-manual"

VUPLUS_BASE_OPTIONAL_RECOMMENDS = "\
  djmount \
  minidlna \
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

