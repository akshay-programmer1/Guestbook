create index IX_9294AD47 on GB_Guestbook (groupId);
create unique index IX_EDD4239 on GB_Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E84D72FD on GB_GuestbookEntry (groupId, guestbookId);
create unique index IX_4A541631 on GB_GuestbookEntry (uuid_[$COLUMN_LENGTH:75$], groupId);