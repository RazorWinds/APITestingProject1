IF OBJECT_ID(N'[__EFMigrationsHistory]') IS NULL
BEGIN
    CREATE TABLE [__EFMigrationsHistory] (
        [MigrationId] nvarchar(150) NOT NULL,
        [ProductVersion] nvarchar(32) NOT NULL,
        CONSTRAINT [PK___EFMigrationsHistory] PRIMARY KEY ([MigrationId])
    );
END;
GO

BEGIN TRANSACTION;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    CREATE TABLE [Streams] (
        [Id] int NOT NULL IDENTITY,
        [Name] nvarchar(50) NOT NULL,
        CONSTRAINT [PK_Streams] PRIMARY KEY ([Id])
    );
END;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    CREATE TABLE [Courses] (
        [Id] int NOT NULL IDENTITY,
        [Name] nvarchar(max) NOT NULL,
        [StreamId] int NOT NULL,
        [Trainer] nvarchar(max) NOT NULL,
        [StartDate] datetime2 NOT NULL,
        [EndDate] datetime2 NOT NULL,
        CONSTRAINT [PK_Courses] PRIMARY KEY ([Id]),
        CONSTRAINT [FK_Courses_Streams_StreamId] FOREIGN KEY ([StreamId]) REFERENCES [Streams] ([Id]) ON DELETE CASCADE
    );
END;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    CREATE TABLE [Spartans] (
        [Id] int NOT NULL IDENTITY,
        [FirstName] nvarchar(50) NOT NULL,
        [LastName] nvarchar(50) NOT NULL,
        [University] nvarchar(max) NULL,
        [Degree] nvarchar(max) NULL,
        [CourseId] int NOT NULL,
        [Graduated] bit NOT NULL,
        CONSTRAINT [PK_Spartans] PRIMARY KEY ([Id]),
        CONSTRAINT [FK_Spartans_Courses_CourseId] FOREIGN KEY ([CourseId]) REFERENCES [Courses] ([Id]) ON DELETE CASCADE
    );
END;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    CREATE INDEX [IX_Courses_StreamId] ON [Courses] ([StreamId]);
END;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    CREATE INDEX [IX_Spartans_CourseId] ON [Spartans] ([CourseId]);
END;
GO

IF NOT EXISTS(SELECT * FROM [__EFMigrationsHistory] WHERE [MigrationId] = N'20230716154308_intial')
BEGIN
    INSERT INTO [__EFMigrationsHistory] ([MigrationId], [ProductVersion])
    VALUES (N'20230716154308_intial', N'7.0.9');
END;
GO

COMMIT;
GO

-- Insert data into Streams table
IF NOT EXISTS(SELECT * FROM [Streams])
BEGIN
    INSERT INTO [Streams] ([Name])
    VALUES
        ('C# Dev'),
        ('C# Test'),
        ('Java Dev'),
        ('Jave Test'),
        ('Java Test'),
        ('DevOps'),
        ('Data'),
        ('Business');
END;
GO

-- Insert data into Courses table
IF NOT EXISTS(SELECT * FROM [Courses])
BEGIN
    INSERT INTO [Courses] ([Name], [StreamId], [Trainer], [StartDate], [EndDate])
    VALUES
        ('TECH 300', 1, 'Phil Windridge', '2023-03-01', '2023-05-01'),
        ('TECH 301', 3, 'Catherine French', '2023-04-01', '2023-06-01'),
        ('TECH 302', 2, 'Nish Mandal', '2023-05-01', '2023-07-01'),
        ('TECH 303', 5, 'Abdul Shahrukh Khan', '2023-06-01', '2023-08-01'),
        ('DATA 304', 6, 'Paula Savaglia', '2023-07-01', '2023-09-01');
END;
GO

-- Insert data into Spartans table
IF NOT EXISTS(SELECT * FROM [Spartans])
BEGIN
    INSERT INTO [Spartans] ([FirstName], [LastName], [University], [Degree], [CourseId], [Graduated])
    VALUES
        ('Sparty', 'McFly', 'University of Rome', 'Time Travel', 1, 0),
        ('John', 'Lennon', 'Liverpool Hope University', 'Songwriting and Composition', 2, 0),
        ('Paul', 'McCartney', 'Liverpool Institute for Performing Arts', 'Music Production and Performance', 3, 0),
        ('Ringo', 'Starr', 'University of Liverpool', 'Percussion Studies', 4, 0),
        ('George', 'Harrison', 'Liverpool John Moore Unis', 'Music Theory', 1, 0),
        ('Jay', 'Z', 'New York University', 'Music Business and Enterpreneurship', 2, 0),
        ('Ravi', 'Shankar', 'UCLA', 'Classical Music', 3, 0),
        ('Nina', 'Simone', 'University of North Carolina', 'Classics', 4, 0),
        ('Beyonce', 'Knowles', 'University of Texas', 'Jazz', 1, 0),
        ('Keke', 'Okereke', 'Kings College, London', 'English Literature', 2, 0),
        ('Taylor', 'Swift', 'University of Pennsylvania', 'Folklore', 3, 0),
        ('Lou', 'Reed', 'Sycrause University', 'Poetry', 4, 0),
        ('Dua', 'Lipa', 'Sylvia Young Theatre School', 'New Rules', 1, 0),
        ('Joan', 'Clarke', 'University of Cambridge', 'Mathematics', 2, 0),
        ('Alan', 'Turing', 'University of Cambridge', 'Mathematics', 3, 0),
        ('Jimi', 'Hendrix', 'Riff University', 'Purple Haze', 4, 0),
        ('Ada', 'Lovelace', 'University of Turin', 'Mathematics', 1, 0),
        ('Marie', 'Curie', 'Flying University', 'Radioactivity', 2, 0),
        ('Stewart', 'Lee', 'University of Oxford', 'English', 3, 0),
        ('Charles', 'Darwin', 'University of Oxford', 'Zoology', 4, 0),
        ('Rosalind', 'Franklin', 'University of Cambridge', 'Natural Science', 1, 0),
        ('Barbara', 'McClintock', 'Cornell University', 'Botany', 2, 0),
        ('Tony', 'Hawks', 'University of Skate', 'Music', 2, 0),
        ('Malala', 'Yousafzai', 'University of Oxford', 'PPE', 3, 0),
        ('Eddie', 'Izzard', 'University of Sheffield', 'Drama', 4, 0),
        ('Wonder', 'Woman', 'Staffordshire University', 'Law', 1, 0),
        ('Jack', 'Black', 'School of Rock', 'Music', 2, 0),
        ('Bill', 'Withers', 'University of Birmingham', 'Biology', 3, 0),
        ('Super', 'Man', 'N/A', 'N/A', 4, 0),
        ('Tom', 'Hanks', 'University of Washington', 'Law', 5, 0),
        ('Russell', 'Howard', 'University of Bristol', 'Drama', 5, 0),
        ('Liam', 'Gallagher', 'Manchester Metropolitan University', 'Music Data', 5, 0),
        ('Noel', 'Gallagher', 'University of Manchester', 'The Beatles', 5, 0);
END;
GO
