CREATE TABLE "_user" (
  "id" integer PRIMARY KEY,
  "username" varchar,
  "email" varchar,
  "password" varchar
);

CREATE TABLE "medal" (
  "id" integer PRIMARY KEY,
  "user_id" integer,
  "name" varchar,
  "description" varchar,
  "date_awarded" date
);

CREATE TABLE "skill_tag" (
  "id" integer PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "skill" (
  "id" integer PRIMARY KEY,
  "tag_id" integer,
  "user_id" integer,
  "level" integer,
  "experience" integer,
  "nex_level_req" integer
);

CREATE TABLE "organization" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "description" varchar
);

CREATE TABLE "organization_member" (
  "id" integer PRIMARY KEY,
  "user_id" integer,
  "organization_id" integer,
  "organization_role" varchar,
  "points" integer
);

CREATE TABLE "project" (
  "id" integer PRIMARY KEY,
  "organization_id" integer,
  "name" varchar,
  "description" varchar,
  "state" varchar
);

CREATE TABLE "project_member" (
  "id" integer PRIMARY KEY,
  "user_id" integer,
  "project_id" integer,
  "project_role" varchar
);

CREATE TABLE "sprint" (
  "id" integer PRIMARY KEY,
  "project_id" integer,
  "start_date" date,
  "end_date" date
);

CREATE TABLE "project_backlog_element" (
  "id" integer PRIMARY KEY,
  "project_id" integer,
  "tag_id" integer,
  "type" varchar,
  "title" varchar,
  "description" varchar,
  "priority" varchar,
  "status" varchar,
  "creation_date" timestamp,
  "due_date" timestamp,
  "completion_date" timestamp
);

CREATE TABLE "sprint_backlog_element" (
  "id" integer PRIMARY KEY,
  "sprint_id" integer,
  "product_backlog_element_id" integer
);

CREATE TABLE "user_story" (
  "id" integer PRIMARY KEY,
  "assigned_to" integer,
  "backlog_element_id" integer,
  "acceptance_criteria" varchar,
  "story_points" integer
);

CREATE TABLE "task" (
  "id" integer PRIMARY KEY,
  "assigned_to" integer,
  "backlog_element_id" integer,
  "estimated_hours" integer,
  "actual_hours" integer
);

CREATE TABLE "reward" (
  "id" integer PRIMARY KEY,
  "organization_id" integer,
  "name" varchar,
  "description" varchar,
  "price" integer
);

CREATE TABLE "scrum_event" (
  "id" integer PRIMARY KEY,
  "project_id" integer,
  "name" varchar,
  "description" varchar,
  "date" timestamp
);

CREATE TABLE "kudo_card" (
  "id" integer PRIMARY KEY,
  "sender_id" integer,
  "receiver_id" integer,
  "title" varchar,
  "message" varchar,
  "style" varchar
);

ALTER TABLE "medal" ADD FOREIGN KEY ("user_id") REFERENCES "_user" ("id");

ALTER TABLE "skill" ADD FOREIGN KEY ("user_id") REFERENCES "_user" ("id");

ALTER TABLE "organization_member" ADD FOREIGN KEY ("user_id") REFERENCES "_user" ("id");

ALTER TABLE "project_member" ADD FOREIGN KEY ("user_id") REFERENCES "_user" ("id");

ALTER TABLE "user_story" ADD FOREIGN KEY ("assigned_to") REFERENCES "_user" ("id");

ALTER TABLE "task" ADD FOREIGN KEY ("assigned_to") REFERENCES "_user" ("id");

ALTER TABLE "kudo_card" ADD FOREIGN KEY ("sender_id") REFERENCES "_user" ("id");

ALTER TABLE "kudo_card" ADD FOREIGN KEY ("receiver_id") REFERENCES "_user" ("id");

ALTER TABLE "organization_member" ADD FOREIGN KEY ("organization_id") REFERENCES "organization" ("id");

ALTER TABLE "project" ADD FOREIGN KEY ("id") REFERENCES "organization" ("id");

ALTER TABLE "reward" ADD FOREIGN KEY ("organization_id") REFERENCES "organization" ("id");

ALTER TABLE "project_member" ADD FOREIGN KEY ("project_id") REFERENCES "project" ("id");

ALTER TABLE "sprint" ADD FOREIGN KEY ("project_id") REFERENCES "project" ("id");

ALTER TABLE "project_backlog_element" ADD FOREIGN KEY ("project_id") REFERENCES "project" ("id");

ALTER TABLE "scrum_event" ADD FOREIGN KEY ("project_id") REFERENCES "project" ("id");

ALTER TABLE "sprint_backlog_element" ADD FOREIGN KEY ("sprint_id") REFERENCES "sprint" ("id");

ALTER TABLE "sprint_backlog_element" ADD FOREIGN KEY ("product_backlog_element_id") REFERENCES "project_backlog_element" ("id");

ALTER TABLE "user_story" ADD FOREIGN KEY ("backlog_element_id") REFERENCES "project_backlog_element" ("id");

ALTER TABLE "task" ADD FOREIGN KEY ("backlog_element_id") REFERENCES "project_backlog_element" ("id");

ALTER TABLE "project_backlog_element" ADD FOREIGN KEY ("tag_id") REFERENCES "skill_tag" ("id");

ALTER TABLE "skill" ADD FOREIGN KEY ("tag_id") REFERENCES "skill_tag" ("id");
